package common;

//public class WebResponse {

//
//}

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Top level web response class, wraps the actual result and contains a holder
 * for possible errors.
 * 
 * @param <T>
 *            The result data type
 */
@JsonInclude(JsonInclude.Include.ALWAYS)
public class WebResponse<T extends Object> {

    private Errors errors;
    private T result;

    public WebResponse() {

    }

    public WebResponse(final T result) {
        this.result = result;
    }

    public WebResponse(final Errors errors) {
        this.errors = errors;
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(final T result) {
        this.result = result;
    }

    public Errors getErrors() {
        return this.errors;
    }

    public void setErrors(final Errors errors) {
        this.errors = errors;
    }

    /**
     * Holds different type of errors.
     */
    public static class Errors implements Serializable {

        private static final long serialVersionUID = 1L;

        private List<Error> globalErrors;
        private List<FieldError> fieldErrors;

        public Errors() {

        }

        /**
         * Constructor used to build the errors with their messages resolved.
         * 
         * @param result
         *            The binding result
         * @param messageSource
         *            The message source for interpolation.
         * @param locale
         *            The locale which the messages should be translated to.
         */
        public Errors(final org.springframework.validation.Errors result, final MessageSource messageSource, final Locale locale) {
            if (result.hasFieldErrors()) {
                this.fieldErrors = new ArrayList<>(result.getFieldErrorCount());
                for (org.springframework.validation.FieldError fe : result.getFieldErrors()) {
                    final FieldError er = new FieldError(fe.getCode(), messageSource.getMessage(fe, locale), fe.getField());
                    this.fieldErrors.add(er);
                }
            }
            if (result.hasGlobalErrors()) {
                this.globalErrors = new ArrayList<>(result.getGlobalErrorCount());
                for (org.springframework.validation.ObjectError oe : result.getGlobalErrors()) {
                    final Error er = new Error(oe.getCode(), messageSource.getMessage(oe, locale));
                    this.globalErrors.add(er);
                }
            }

        }

        public List<Error> getGlobalErrors() {
            return this.globalErrors;
        }

        public void setGlobalErrors(final List<Error> globalErrors) {
            this.globalErrors = globalErrors;
        }

        public List<FieldError> getFieldErrors() {
            return this.fieldErrors;
        }

        public void setFieldErrors(final List<FieldError> fieldErrors) {
            this.fieldErrors = fieldErrors;
        }

        /**
         * Checks whether this errors object contains any errors.
         *
         * @return <code>true</code> if there are errors
         */
        public boolean hasErrors() {
            return !CollectionUtils.isEmpty(this.fieldErrors) || !CollectionUtils.isEmpty(this.globalErrors);
        }
    }

    /**
     * Holds a single error.
     */
    public static class Error implements Serializable {

        private static final long serialVersionUID = 1L;

        private String code;
        private String message;

        public Error() {

        }

        public Error(final String code, final String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return this.code;
        }

        public void setCode(final String code) {
            this.code = code;
        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(final String message) {
            this.message = message;
        }
    }

    /**
     * This error is tied to a specific field in the HTTP request.
     */
    public static class FieldError extends Error {

        private static final long serialVersionUID = 1L;

        private String field;

        public FieldError() {
            super();
        }

        public FieldError(final String code, final String message, final String field) {
            super(code, message);
            this.field = field;
        }

        public String getField() {
            return this.field;
        }

        public void setField(final String field) {
            this.field = field;
        }
    }
}
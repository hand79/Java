package com.max.xml.exception;

public enum Errors {

		SUCCESS		(0, "Success")
		, ERR_999	(999, " [XX] Unknown error")
		, ERR_500	(5000, "[XX] Communication exception")
		, ERR_9999	(9999, " [XX] Unknown error")
		;

		Errors(Integer code, String message) {
			this.code = code;
			this.message = message;
		}

		private Integer code;

		private String message;

		public Integer getCode() {
			return code;
		}

		public void setCode(Integer code) {
			this.code = code;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

	}



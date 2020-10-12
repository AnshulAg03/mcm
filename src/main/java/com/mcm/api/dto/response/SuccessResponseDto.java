package com.mcm.api.dto.response;

public class SuccessResponseDto {
		private String code;
		
		
		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		
		public SuccessResponseDto() {
			
		}

		public SuccessResponseDto(String code) {
			super();
			this.code = code;
		}

		@Override
		public String toString() {
			return "{\"code\":\"" + code + "\"}";
		}
		
		
}

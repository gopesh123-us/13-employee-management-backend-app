package live.learnjava.employeemanagement.bindings;

import org.springframework.hateoas.PagedModel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomPagedResponseDTO<T> {
	public final PagedModel<T> pagedModel;
	public final PageMetaDataCustom pageMetaData;

	public CustomPagedResponseDTO(PagedModel<T> thePagedModel, PageMetaDataCustom thePageMetaData) {
		this.pagedModel = thePagedModel;
		this.pageMetaData = thePageMetaData;
	}

	@JsonProperty("page")
	public PagedModel.PageMetadata getMetaData() {
		System.out.println(pagedModel.getMetadata());
		return pagedModel.getMetadata();
	}

	public static class PageMetaDataCustom {

		private final boolean isFirst;
		private final boolean isLast;

		public PageMetaDataCustom(boolean isFirst, boolean isLast) {
			this.isFirst = isFirst;
			this.isLast = isLast;
		}

		@JsonProperty("isFirst")
		public boolean isFirst() {
			return isFirst;
		}

		@JsonProperty("isLast")
		public boolean isLast() {
			return isLast;
		}
	}

}

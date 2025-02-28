package live.learnjava.employeemanagement.bindings;

import org.springframework.hateoas.PagedModel;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This is a wrapper of PagedModel class and added missing page parameters -
 * isFirst, isLast
 */
public class CustomPagedModelDTO<T> {
	public final PagedModel<T> pagedModel;
	public final PagedMetaData pageMetaData;

	public CustomPagedModelDTO(PagedModel<T> thePagedModel, PagedMetaData thePagedMetaData) {
		this.pagedModel = thePagedModel;
		this.pageMetaData = thePagedMetaData;
	}

	@JsonProperty("page")
	public PagedModel.PageMetadata getMetaData() {
		System.out.println(pagedModel.getMetadata());
		return pagedModel.getMetadata();
	}

	public static class PagedMetaData {
		private boolean isFirst;
		private boolean isLast;

		public PagedMetaData(boolean isFirst, boolean isLast) {
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

/**
 * 
 */
package com.taotao.manage.web.bean;

import java.util.List;

/**
 * @author hc-3020-i3
 *
 */
public class EasyUIResult {

	private Long total;

	private List<?> rows;

	public EasyUIResult() {
		super();
	}

	public EasyUIResult(Long total, List<?> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	/**
	 * @return the total
	 */
	public Long getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(Long total) {
		this.total = total;
	}

	/**
	 * @return the rows
	 */
	public List<?> getRows() {
		return rows;
	}

	/**
	 * @param rows
	 *            the rows to set
	 */
	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}

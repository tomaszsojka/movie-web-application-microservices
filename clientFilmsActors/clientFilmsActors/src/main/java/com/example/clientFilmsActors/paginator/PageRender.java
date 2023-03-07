package com.example.clientFilmsActors.paginator;

import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class PageRender<T> {

	private String url;
	private Page<T> page;

	private int totalPages;

	private int numElementsInPage;

	private int currentPage;

	private List<PageItem> pages;

	public PageRender(String url, Page<T> page) {
		this.url = url;
		this.page = page;
		this.pages = new ArrayList<PageItem>();

		numElementsInPage = 5;
		//totalPaginas = (int) Math.ceil(page.getTotalElements() / numElementosPorPagina);
		totalPages = page.getTotalPages();
		currentPage = page.getNumber() + 1;
		int from, until;
		if (totalPages <= numElementsInPage) {
			from = 1;
			until = totalPages;
		} else {
			if (currentPage <= numElementsInPage / 2) {
				from = 1;
				until = numElementsInPage;
			} else if (currentPage >= totalPages - numElementsInPage / 2) {
				from = totalPages - numElementsInPage + 1;
				until = numElementsInPage;
			} else {
				from = currentPage - numElementsInPage / 2;
				until = numElementsInPage;
			}
		}

		for (int i = 0; i < until; i++) {
			pages.add(new PageItem(from + i, currentPage == from + i));
		}

	}

	public String getUrl() {
		return url;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public List<PageItem> getPages() {
		return pages;
	}

	public boolean isFirst() {
		return page.isFirst();
	}

	public boolean isLast() {
		return page.isLast();
	}

	public boolean isHasNext() {
		return page.hasNext();
	}

	public boolean isHasPrevious() {
		return page.hasPrevious();
	}

}

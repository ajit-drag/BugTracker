package com.mindtree.coe.bugtracker.dto;

import java.util.List;

public class BugDtoListDto {
	private List<BugDto> bugDtoList;
	
	public BugDtoListDto(List<BugDto> bugDtoList) {
		super();
		this.bugDtoList = bugDtoList;
	}

	public BugDtoListDto() {
		// TODO Auto-generated constructor stub
	}

	public List<BugDto> getBugDtoList() {
		return bugDtoList;
	}

	public void setBugDtoList(List<BugDto> bugDtoList) {
		this.bugDtoList = bugDtoList;
	}
}

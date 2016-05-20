package com.mindtree.coe.bugtracker.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import com.mindtree.coe.bugtracker.dto.BugSupportDto;
import com.mindtree.coe.bugtracker.dto.BugSupportDtoListDto;
import com.mindtree.coe.bugtracker.entity.Bug;
import com.mindtree.coe.bugtracker.entity.Status;

public class EntityToDto {
	// This method will convert Bug to BugSupportDto
	public BugSupportDto mapBugToBugSupport(Bug bug) {
		BugSupportDto bugSupportDto = new BugSupportDto();
		bugSupportDto.setId(bug.getId());
		bugSupportDto.setTitle(bug.getTitle());
		bugSupportDto.setDescription(bug.getDesciption());
		bugSupportDto.setDate(bug.getSubmittedDate());
		bugSupportDto.setSubmittedBy(bug.getSubmittedBy().getName());
		return bugSupportDto;

	}

	// This method will convert BugList to BugSupportDtoList
	public BugSupportDtoListDto mapBugListToBugSupportDtoListDto(List<Bug> bugList) {
		BugSupportDtoListDto bugSupportDtoListDto = new BugSupportDtoListDto();
		List<BugSupportDto> bugSupportDtoList = new ArrayList<BugSupportDto>();

		for (Bug bug : bugList) {
			if (bug.getStatus().equals(Status.inProgress)) {
				BugSupportDto bugSupportDto = mapBugToBugSupport(bug);
				bugSupportDtoList.add(bugSupportDto);
			}
		}
		bugSupportDtoListDto.setBugSupportDtoList(bugSupportDtoList);
		return bugSupportDtoListDto;

	}
}

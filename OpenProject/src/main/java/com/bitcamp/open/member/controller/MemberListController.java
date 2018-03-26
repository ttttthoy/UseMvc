package com.bitcamp.open.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.open.member.model.Member;
import com.bitcamp.open.member.service.MemberListService;

@Controller
public class MemberListController {

	@Autowired
	private MemberListService service;

	@RequestMapping("/member/memberList")
	public String memberList(Model model) {

		List<Member> members = service.getMemberList();

		model.addAttribute("members", members);

		return "member/memberList";

	
	
	}

}

package com.demo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.matrix.dddsupport.recovery.snapshot.SnapshotService;
import com.matrix.view.CommonVO;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private SnapshotService snapshotService;

	@RequestMapping("/savesnapshot")
	@ResponseBody
	public CommonVO savesnapshot(String disruptorName) {
		CommonVO vo = new CommonVO();
		try {
			snapshotService.saveSnapshot(disruptorName);
		} catch (Exception e) {
			vo.setSuccess(false);
			vo.setMsg(e.getMessage());
			return vo;
		}
		return vo;
	}
}

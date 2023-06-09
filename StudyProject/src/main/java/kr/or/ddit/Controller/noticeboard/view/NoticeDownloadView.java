package kr.or.ddit.Controller.noticeboard.view;

import java.io.File;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.view.AbstractView;

public class NoticeDownloadView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> noticeFileMap = (Map<String, Object>) model.get("noticeFileMap");
		
		File saveFile = new File(noticeFileMap.get("fileSavepath").toString());
		String fileName = (String) noticeFileMap.get("fileName");
		String agent = request.getHeader("User-Agent");	// 브라우저에 대한 한글 세팅 깨지지 않기 위해서 설정
		if(StringUtils.containsIgnoreCase(agent, "mise") ||
		   StringUtils.containsIgnoreCase(agent,"trident")) {
			fileName = URLEncoder.encode(fileName, "UTF-8");		// IE, Chrome
		} else  {
			fileName = new String(fileName.getBytes(), "ISO-8859-1");	// firefox, chrome
		}
		
		response.setHeader("Content-Disposition", "attachment; filename=\""+ fileName + "\"");
		response.setHeader("Content-Length", noticeFileMap.get("fileSize").toString());
		
		// try-with-resource
		// () 안에 사용되느 객체를 finally 구문에서 close하지 않아도 try catch가 완료되면 자동으로 해당 객체가 close
		try (
			OutputStream os = response.getOutputStream();
		) {
			FileUtils.copyFile(saveFile, os);	// 파일 다운로드
		}
	}

}

package br.com.caelum.vraptor.controller;

import java.sql.Date;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.NoticeDAO;
import br.com.caelum.vraptor.models.Notice;

@Controller
public class NoticeController {
	private Result result;
	private NoticeDAO noticeDAO;
	
	/**
	 * @deprecated CDI eyes only
	 */
	@Deprecated
	protected NoticeController() {
		this(null, null);
	}
	
	@Inject
	public NoticeController(Result result, NoticeDAO noticeDAO) {
		this.result = result;
		this.noticeDAO = noticeDAO;
	}

	@Get("/")
	public void index() {
	}

	@Get
	@Path(value = "/notice/create", priority= Path.HIGH)
	public void create() {
	}

	@Post
	@Path(value="/notice/add", priority= Path.HIGHEST)
	public void add(Notice notice) {
		notice.setPublication(new Date(System.currentTimeMillis()));
		noticeDAO.insert(notice);
		result.redirectTo(this).index();
	}

	@Get("/notice/delete/{id}")
	public void delete(int id) {
		noticeDAO.delete(id);
		result.redirectTo(this).index();
	}

	@Get("/notice/{title}")
	public Notice seeNotice(String title) {
		return noticeDAO.getNotice(title);
	}
}
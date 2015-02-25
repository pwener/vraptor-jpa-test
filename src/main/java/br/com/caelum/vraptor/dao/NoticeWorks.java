package br.com.caelum.vraptor.dao;

import br.com.caelum.vraptor.models.Notice;

public interface NoticeWorks {
	void insert(Notice notice);
	Notice getNotice(String title);
	void delete(int id);
}

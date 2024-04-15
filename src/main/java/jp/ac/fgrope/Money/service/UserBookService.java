package jp.ac.fgrope.Money.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jp.ac.fgrope.Money.model.UserBook;
import jp.ac.fgrope.Money.repository.UserBookRepository;

@Service
@Transactional
public class UserBookService {

	@Autowired
	private UserBookRepository repository;

	/**
	 * アドレス帳一覧の取得
	 * @return List<UserBook>
	 */
	public List<UserBook> getUserList() {
	    List<UserBook> entityList = this.repository.findAll();
	    return entityList;
	}

	/**
	 * 詳細データの取得
	 * @param @NonNull Long index
	 * @return  UserBook
	 */
	public UserBook get(@NonNull Long index) {
		UserBook UserBook = this.repository.findById(index).orElse(new UserBook());
		return UserBook;
	}

	/**
	 * アドレス帳データの保存
	 * @param UserBook UserBook
	 */
	public void save(@NonNull UserBook UserBook) {
		this.repository.save(UserBook);
	}

	/**
	 * アドレス帳データの削除
	 * @param @NonNull Long index
	 */
	public void delete(@NonNull Long index) {
		this.repository.deleteById(index);
	}
}

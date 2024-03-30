package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.UsersEntity;
import com.example.demo.form.UsersRequest;
import com.example.demo.form.UsersUpdateRequest;
import com.example.demo.repository.UsersRepository;

/**
 * ユーザー情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UsersService {
  /**
   * ユーザー情報 Repository
   */
  @Autowired
  private UsersRepository usersRepository;


  /**
   * ユーザー情報 全検索
   * @return 検索結果
   */
  public List<UsersEntity> searchAll() {
    return usersRepository.findAll();
  }
  /**
   * ユーザー情報 主キー検索
   * @return 検索結果
   */
  public UsersEntity findById(Integer id) {
    return usersRepository.getOne(id);
  }


  /**
   * ユーザー情報 新規登録
   * @param user ユーザー情報
   */
  public void create(UsersRequest usersRequest) {
    Date now = new Date();
    UsersEntity users = new UsersEntity();
    users.setName(usersRequest.getName());
    users.setAddress(usersRequest.getAddress());
    users.setPhone(usersRequest.getPhone());
    users.setCreateDate(now);
    users.setUpdateDate(now);
    usersRepository.save(users);
  }
  /**
   * ユーザー情報 更新
   * @param user ユーザー情報
   */
  public void update(UsersUpdateRequest usersUpdateRequest) {
    UsersEntity users = findById(usersUpdateRequest.getId());
    users.setAddress(usersUpdateRequest.getAddress());
    users.setName(usersUpdateRequest.getName());
    users.setPhone(usersUpdateRequest.getPhone());
    users.setUpdateDate(new Date());
    usersRepository.save(users);
  }
  /**
   * ユーザー情報 物理削除
   * @param id ユーザーID
   */
  public void delete(Integer id) {
      UsersEntity users = findById(id);
      usersRepository.delete(users);
  }
}
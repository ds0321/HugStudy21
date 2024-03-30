package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.UsersEntity;
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
}
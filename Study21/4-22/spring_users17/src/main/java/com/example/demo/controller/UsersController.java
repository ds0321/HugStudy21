package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.UsersEntity;
import com.example.demo.service.UsersService;

/**
 * ユーザー情報 Controller
 */
@Controller
public class UsersController {

  /**
   * ユーザー情報 Service
   */
  @Autowired
  UsersService usersService;

  /**
   * ユーザー情報一覧画面を表示
   * @param model Model
   * @return ユーザー情報一覧画面のHTML
   */
  @RequestMapping("/users/list")
  public String usersList(Model model) {
    List<UsersEntity> userslist = usersService.searchAll();
    model.addAttribute("useslist", userslist);
    return "users/list";
  }
  /**
   * ユーザー新規登録画面を表示
   * @param model Model
   * @return ユーザー情報一覧画面
   */
  @RequestMapping("/users/add")
  public String usersRegister(Model model) {
    return "users/add";
  }

  /**
   * ユーザー情報詳細画面を表示
   * @param id 表示するユーザーID
   * @param model Model
   * @return ユーザー情報詳細画面
   */
  @GetMapping("/users/{id}")
  public String usersDetail(@PathVariable Integer id, Model model) {
    return "users/view";
  }
  
}
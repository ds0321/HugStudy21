package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.UsersEntity;
import com.example.demo.form.UsersRequest;
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
  
  /**
   * ユーザー新規登録画面を表示
   * @param model Model
   * @return ユーザー情報一覧画面
   */
  @RequestMapping("/users/add")
  public String usersRegister(Model model) {
    model.addAttribute("usersRequest", new UsersRequest());
    return "users/add";
  }

  /**
   * ユーザー新規登録
   * @param userRequest リクエストデータ
   * @param model Model
   * @return ユーザー情報一覧画面
   */
  @RequestMapping("/users/create")
  public String usersCreate(@Validated @ModelAttribute UsersRequest usersRequest, BindingResult result, Model model) {
    if (result.hasErrors()) {
      // 入力チェックエラーの場合
      List<String> errorList = new ArrayList<String>();
      for (ObjectError error : result.getAllErrors()) {
        errorList.add(error.getDefaultMessage());
      }
      //エラー判定後の画面遷移
      model.addAttribute("validationError", errorList);
      return "users/add";
    }
    // ユーザー情報の登録
    usersService.create(usersRequest);
    return "redirect:/users/list";
  }

  /**
   * ユーザー情報詳細画面を表示
   * @param id 表示するユーザーID
   * @param model Model
   * @return ユーザー情報詳細画面
   */
  @GetMapping("/users/{id}")
  public String userDetail(@PathVariable Integer id, Model model) {
    UsersEntity users = usersService.findById(id);
    model.addAttribute("usersData", users);
    return "users/view";
  }
  
}
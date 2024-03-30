package com.example.demo.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ユーザー情報更新リクエストデータ
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class UsersUpdateRequest extends UsersRequest implements Serializable {

  /**
   * ユーザーID
   */
  @NotNull
  private Integer id;
}
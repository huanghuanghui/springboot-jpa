package com.hhh.springbootjpa.response;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.io.Serializable;

/**
 * @author hhh
 * @date 2020/1/22 15:54
 * @Despriction
 */
@Data
public class PageResMessage<T> implements Serializable {
  private Integer code;
  private String message;
  private Long totalElements;
  private Integer totalPages;
  private T content;

  public static PageResMessage success(Page p) {
    PageResMessage page = new PageResMessage();
    page.setCode(200);
    page.setMessage("请求成功");
    page.setTotalElements(p.getTotalElements());
    page.setTotalPages(p.getTotalPages());
    page.setContent(p.getContent());
    return page;
  }
}

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
  private Integer currentPage;
  private T content;

  public static PageResMessage success(Page p) {
    if (p==null){
      return PageResMessage.success("当前数据为空");
    }
    PageResMessage page = new PageResMessage();
    page.setCode(200);
    page.setMessage("请求成功");
    page.setCurrentPage(p.getPageable()==null?0:p.getPageable().getPageNumber());
    page.setTotalElements(p.getTotalElements());
    page.setTotalPages(p.getTotalPages());
    page.setContent(p.getContent());
    return page;
  }

  public static PageResMessage success(String message) {
    PageResMessage page = new PageResMessage();
    page.setCode(200);
    page.setMessage(message);
    return page;
  }
}

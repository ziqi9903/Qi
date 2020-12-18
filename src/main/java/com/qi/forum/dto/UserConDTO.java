package com.qi.forum.dto;

import com.qi.forum.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserConDTO {
    /**
     *  users          记录查询到所有的用户信息
     *  showPrevious   显示上一页 按钮
     *  showNext       显示下一页 按钮
     *
     *  showFirstPage   显示首页
     *  showEndPage     显示最后一页
     *
     *  currentPage     当前所在页
     *  pages           可以显示页数数组
     *
     *  totalPage       所有用户占据总页数
     */
    private List<User> users;

    private boolean showPrevious;
    private boolean showNext;

    private boolean showFirstPage;
    private boolean showEndPage;

    private Integer currentPage;
    private List<Integer> pages = new ArrayList<>();
    private Integer totalPage;

    /**
     * @param page 第几页
     * @param size 每页的个数
     */
    public void setPagination( Integer page, Integer size) {
        /**
         * 首先判断数据合法性 是否两端越界
         */
        if(page < 1){
            page = 1;
        }
        if(page > totalPage){
            page = totalPage;
        }

        this.currentPage = page;
        pages.add(page);

        /**
         * 显示当前所在页 左右三页 若不存在就不显示
         */
        for(int i = 1; i <= 3; i++){
            if(page - i > 0){
                pages.add(0,page -i);
            }
            if (page + i <= totalPage){
                pages.add(page + i);
            }
        }
        /**
         * 是否展示 上一页 按钮 若为第一页则该页为首页
         */
        if (page == 1){
            this.showPrevious = false;
        }else{
            this.showPrevious = true;
        }
        if(page == totalPage){
            this.showNext = false;
        }else{
            this.showNext = true;
        }
        /**
         * 是否 展示 首页 按钮
         */
        if(pages.contains(1)){
            this.showFirstPage = false;
        }else{
            this.showFirstPage = true;
        }
        /**
         * 是否 展示 末页 按钮
         */
        if(pages.contains(totalPage)){
            this.showEndPage = false;
        }else{
            this.showEndPage = true;
        }
    }


}

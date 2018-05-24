package com.saileijieji.mymvp.bean;

import java.util.List;

/**
 * @describe: EasyMvp
 * @author: 武梁
 * @date: 2018/5/24 15:07
 * @mailbox: 1034905058@qq.com
 */

public class GetMessageCenterBean {


        /**
         * id : 1
         * remarks : 您有新的消息，请及时处理
         * createDate : 2018-05-17 10:36:44
         * title : 系统消息
         * icon : http://dev.saileikeji.com:10010/ebangren/comm_1.png
         */

        private String id;
        private String remarks;
        private String createDate;
        private String title;
        private String icon;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

}

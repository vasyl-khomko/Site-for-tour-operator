package toursite.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Vasyl on 29.09.2015.
 */
@Entity
@Table(name = "conversation_reply", schema = "public")
public class ConversationReply {
    private int conversationReplyId;
    private String reply;
    private Timestamp createTime;
    private int conversationId;
    private int userId;

    @Id
    @Column(name = "conversation_reply_id")
    public int getConversationReplyId() {
        return conversationReplyId;
    }

    public void setConversationReplyId(int conversationReplyId) {
        this.conversationReplyId = conversationReplyId;
    }

    @Basic
    @Column(name = "reply")
    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "conversation_id")
    public int getConversationId() {
        return conversationId;
    }

    public void setConversationId(int conversationId) {
        this.conversationId = conversationId;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConversationReply that = (ConversationReply) o;

        if (conversationId != that.conversationId) return false;
        if (conversationReplyId != that.conversationReplyId) return false;
        if (userId != that.userId) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (reply != null ? !reply.equals(that.reply) : that.reply != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = conversationReplyId;
        result = 31 * result + (reply != null ? reply.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + conversationId;
        result = 31 * result + userId;
        return result;
    }
}

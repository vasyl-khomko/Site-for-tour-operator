package toursite.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by Vasyl on 29.09.2015.
 */
@Entity
public class Conversation {
    private int conversationId;
    private Timestamp createTime;
    private int userIdOne;
    private int userIdTwo;

    @Id
    @Column(name = "conversation_id")
    public int getConversationId() {
        return conversationId;
    }

    public void setConversationId(int conversationId) {
        this.conversationId = conversationId;
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
    @Column(name = "user_id_one")
    public int getUserIdOne() {
        return userIdOne;
    }

    public void setUserIdOne(int userIdOne) {
        this.userIdOne = userIdOne;
    }

    @Basic
    @Column(name = "user_id_two")
    public int getUserIdTwo() {
        return userIdTwo;
    }

    public void setUserIdTwo(int userIdTwo) {
        this.userIdTwo = userIdTwo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Conversation that = (Conversation) o;

        if (conversationId != that.conversationId) return false;
        if (userIdOne != that.userIdOne) return false;
        if (userIdTwo != that.userIdTwo) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = conversationId;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + userIdOne;
        result = 31 * result + userIdTwo;
        return result;
    }
}

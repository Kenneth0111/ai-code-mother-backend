package com.example.aicodemother.service;

import com.example.aicodemother.model.dto.chathistory.ChatHistoryQueryRequest;
import com.example.aicodemother.model.entity.ChatHistory;
import com.example.aicodemother.model.entity.User;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;

import java.time.LocalDateTime;

/**
 * 对话历史 服务层。
 *
 * @author <a href="https://github.com/Kenneth0111">程序员张博洋</a>
 */
public interface ChatHistoryService extends IService<ChatHistory> {

    /**
     * 添加对话历史
     *
     * @param appId       应用id
     * @param message     消息
     * @param messageType 消息类型
     * @param userId      用户id
     * @return 是否成功
     */
    boolean addChatMessage(Long appId, String message, String messageType, Long userId);

    /**
     * 根据应用 id 删除对话历史
     *
     * @param appId 应用id
     * @return 是否成功
     */
    boolean deleteByAppId(Long appId);

    /**
     * 分页查询某app的对话历史
     *
     * @param appId          应用id
     * @param pageSize       页面大小
     * @param lastCreateTime 最后一条记录的创建时间
     * @param loginUser      登录用户
     * @return 对话历史
     */
    Page<ChatHistory> listAppChatHistoryByPage(Long appId, int pageSize,
                                               LocalDateTime lastCreateTime,
                                               User loginUser);

    /**
     * 加载历史对话到内存
     *
     * @param appId      应用id
     * @param chatMemory 对话记忆
     * @param maxCount   最大数量
     * @return 加载的数量
     */
    int loadChatHistoryToMemory(Long appId, MessageWindowChatMemory chatMemory, int maxCount);

    /**
     * 构造查询条件
     *
     * @param chatHistoryQueryRequest 对话历史查询请求
     * @return 查询条件
     */
    QueryWrapper getQueryWrapper(ChatHistoryQueryRequest chatHistoryQueryRequest);
}

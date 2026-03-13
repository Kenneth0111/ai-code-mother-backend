package com.example.aicodemother.service;

import com.example.aicodemother.model.dto.app.AppAddRequest;
import com.example.aicodemother.model.dto.app.AppQueryRequest;
import com.example.aicodemother.model.entity.User;
import com.example.aicodemother.model.vo.AppVO;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.example.aicodemother.model.entity.App;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * 应用 服务层。
 *
 * @author <a href="https://github.com/Kenneth0111">程序员张博洋</a>
 */
public interface AppService extends IService<App> {

    /**
     * 通过对话生成应用代码
     *
     * @param appId 应用 ID
     * @param message 提示词
     * @param loginUser 登录用户
     * @return 生成结果流
     */
    Flux<String> chatToGenCode(Long appId, String message, User loginUser);

    /**
     * 创建应用
     *
     * @param appAddRequest 应用创建请求
     * @param loginUser 登录用户
     * @return 应用 ID
     */
    Long createApp(AppAddRequest appAddRequest, User loginUser);

    /**
     * 应用部署
     *
     * @param appId 应用 ID
     * @param loginUser 登录用户
     * @return 可访问的部署地址
     */
    String deployApp(Long appId, User loginUser);

    /**
     * 异步生成应用截图，得到cosUrl，并更新数据库
     *
     * @param appId 应用ID
     * @param appUrl 应用访问URL
     */
    void generateAppScreenshotAsync(Long appId, String appUrl);

    /**
     * 获取应用封装类
     *
     * @param app 应用
     * @return AppVO
     */
    AppVO getAppVO(App app);

    /**
     * 获取应用封装列表
     *
     * @param appList 应用列表
     * @return AppVOList
     */
    List<AppVO> getAppVOList(List<App> appList);

    /**
     * 构造应用查询条件
     *
     * @param appQueryRequest 应用查询条件
     * @return 查询条件
     */
    QueryWrapper getQueryWrapper(AppQueryRequest appQueryRequest);

}

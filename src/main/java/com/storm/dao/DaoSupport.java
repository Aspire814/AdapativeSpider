package com.storm.dao;

import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.storm.common.Page;

public class DaoSupport<T> {
    protected T mapper;
    
    private String mapperClassName;

    protected SqlSession sqlSession;
    
    private T getMapper() {
        @SuppressWarnings("unchecked")
        Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        mapperClassName = entityClass.getName();
        return sqlSession.getMapper(entityClass);
    }

    @Autowired
    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
        mapper = getMapper();
    }

    protected SqlSession getSqlSession() {
        return sqlSession;
    }
    
    /**
     * 通用分页查询
     * 
     * @param methodname 数据查询目标方法
     * @param parameter 查询参数
     * @param page 分页参数
     * @return
     * @author 李斯
     * @date 2018年7月16日 下午5:13:57 
     * @version V1.0
     */
    protected <E> List<E> selectList(String methodname, Object parameter, Page<E> page) {
        page.setPageCount((int) Math.ceil(page.getTotal() * 1.0 / page.getPageSize()));
        RowBounds _page = new RowBounds(page.getStartRow(), page.getPageSize());
        String statement = this.mapperClassName + "." + methodname;
        List<E> datas = sqlSession.selectList(statement, parameter, _page);
        page.setDatas(datas);
        return datas;
    }
    
    protected <K, V> Map<K, V> selectMap(String methodname, Object parameter, String mapKey, Page<V> page) {
        page.setPageCount((int) Math.ceil(page.getTotal() * 1.0 / page.getPageSize()));
        RowBounds _page = new RowBounds(page.getStartRow(), page.getPageSize());
        String statement = this.mapper.getClass().getName() + "." + methodname;
        Map<K, V> map = sqlSession.selectMap(statement, parameter, mapKey, _page);
        if (map != null && map.values() != null) {
            List<V> datas = new ArrayList<V>();
            datas.addAll(map.values());
            page.setDatas(datas);
        } else {
            page.setDatas(null);
        }
        return map;
    }
    
    protected void select(String queryMethod, Object parameter, Page<T> page, ResultHandler<?> handler) {
        page.setPageCount((int) Math.ceil(page.getTotal() * 1.0 / page.getPageSize()));
        RowBounds _page = new RowBounds(page.getStartRow(), page.getPageSize());
        String statement = this.mapper.getClass().getName() + "." + queryMethod;
        sqlSession.select(statement, parameter, _page, handler);
    }

    // ----------------------------------------------------------------

    @SuppressWarnings("hiding")
    protected <T> T selectOne(String statement) {
        return sqlSession.selectOne(statement);
    }

    @SuppressWarnings("hiding")
    protected <T> T selectOne(String statement, Object parameter) {
        return sqlSession.selectOne(statement, parameter);
    }

    protected <E> List<E> selectList(String statement) {
        return sqlSession.selectList(statement);
    }

    protected <E> List<E> selectList(String statement, Object parameter) {
        return sqlSession.selectList(statement, parameter);
    }

    protected <E> List<E> selectList(String statement, Object parameter, RowBounds rowBounds) {
        return sqlSession.selectList(statement, parameter, rowBounds);
    }

    protected <K, V> Map<K, V> selectMap(String statement, String mapKey) {
        return sqlSession.selectMap(statement, mapKey);
    }

    protected <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey) {
        return sqlSession.selectMap(statement, parameter, mapKey);
    }

    protected <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey, RowBounds rowBounds) {
        return sqlSession.selectMap(statement, parameter, mapKey, rowBounds);
    }

    protected void select(String statement, Object parameter, ResultHandler<?> handler) {
        sqlSession.select(statement, parameter, handler);
    }

    protected void select(String statement, ResultHandler<?> handler) {
        sqlSession.select(statement, handler);
    }

    protected void select(String statement, Object parameter, RowBounds rowBounds, ResultHandler<?> handler) {
        sqlSession.select(statement, parameter, rowBounds, handler);
    }

    protected int insert(String statement) {
        return sqlSession.insert(statement);
    }

    protected int insert(String statement, Object parameter) {
        return sqlSession.insert(statement, parameter);
    }

    protected int update(String statement) {
        return sqlSession.update(statement);
    }

    protected int update(String statement, Object parameter) {
        return sqlSession.update(statement, parameter);
    }

    protected int delete(String statement) {
        return sqlSession.delete(statement);
    }

    protected int delete(String statement, Object parameter) {
        return sqlSession.delete(statement, parameter);
    }

    protected void commit() {
        sqlSession.commit();
    }

    protected void commit(boolean force) {
        sqlSession.commit(force);
    }

    protected void rollback() {
        sqlSession.rollback();
    }

    protected void rollback(boolean force) {
        sqlSession.rollback(force);
    }

    protected List<BatchResult> flushStatements() {
        return sqlSession.flushStatements();
    }

    protected void close() {
        sqlSession.close();
    }

    protected void clearCache() {
        sqlSession.clearCache();
    }

    protected Configuration getConfiguration() {
        return sqlSession.getConfiguration();
    }

    @SuppressWarnings("hiding")
    protected <T> T getMapper(Class<T> type) {
        return sqlSession.getMapper(type);
    }

    protected Connection getConnection() {
        return sqlSession.getConnection();
    }
}

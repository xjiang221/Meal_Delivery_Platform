package com.sky.service;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.result.PageResult;
import com.sky.vo.DishItemVO;
import com.sky.vo.SetmealVO;

import java.util.List;

public interface SetmealService {

    /**
     * 添加套餐
     *
     * @param setmealDTO
     */
    void addWithDish(SetmealDTO setmealDTO);

    /**
     * 分页查询套餐
     *
     * @param setmealPageQueryDTO
     * @return
     */
    PageResult page(SetmealPageQueryDTO setmealPageQueryDTO);

    /**
     * 删除套餐
     *
     * @param ids
     */
    void delete(List<Long> ids);

    /**
     * 根据id查询套餐
     *
     * @param id
     * @return
     */
    SetmealVO getById(Long id);

    /**
     * 更新套餐
     *
     * @param setmealDTO
     */
    void update(SetmealDTO setmealDTO);

    /**
     * 启用或停用套餐
     *
     * @param status
     * @param id
     */
    void startOrStop(Integer status, Long id);

    /**
     * 条件查询
     *
     * @param setmeal
     * @return
     */
    List<Setmeal> list(Setmeal setmeal);

    /**
     * 根据id查询菜品选项
     *
     * @param id
     * @return
     */
    List<DishItemVO> getDishItemById(Long id);
}

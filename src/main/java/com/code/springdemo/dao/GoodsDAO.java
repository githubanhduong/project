package com.code.springdemo.dao;

import java.util.List;

import com.code.springdemo.entity.ActivityAreas;
import com.code.springdemo.entity.Goods;
import com.code.springdemo.entity.Review;

public interface GoodsDAO {

	void addGoods(Goods newGoods);

	List<Goods> getgoods();

	Goods getgoodsdetail(int goodsNo);

	void saveReview(Review newReview);

	List<Review> getReview(int goodsNo);

	void deleteGoods(int goodsNo);

	List<Goods> getgoods(int subCategoryNo);

	List<Goods> getgoods(ActivityAreas activityAreas);

	List<Goods> getgoods(int subCategoryNo, ActivityAreas activityAreas);

}

package com.example.studentscheduler.Database;

import android.app.Application;

import com.example.studentscheduler.DAO.PartDAO;
import com.example.studentscheduler.DAO.ProductDAO;
import com.example.studentscheduler.Entity.Part;
import com.example.studentscheduler.Entity.Product;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {
    private PartDAO mPartDAO;
    private ProductDAO mProductDAO;
    private List<Product> mAllProducts;
    private List<Part> mAllParts;

    private static int NUMBER_OF_THREADS=4;
    static final ExecutorService databaseExecutor= Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public Repository(Application application) {
        BicycleDatabaseBuilder db=BicycleDatabaseBuilder.getDatabase(application);
        mPartDAO=db.partDAO();
        mProductDAO=db.productDAO();
    }

    public void insertProduct(Product product) {
        databaseExecutor.execute(() -> {
            mProductDAO.insert(product);
        });
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Product>getAllProducts() {
        databaseExecutor.execute(()->{
            mAllProducts = mProductDAO.getAllProducts();
        });

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mAllProducts;
    }

    public void updateProduct(Product product) {
        databaseExecutor.execute(() -> {
            mProductDAO.update(product);
        });

        try{
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(Product product) {
        databaseExecutor.execute(() -> {
            mProductDAO.delete(product);
        });

        try{
            Thread.sleep(1000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void insertPart(Part part) {
        databaseExecutor.execute(() -> {
            mPartDAO.insert(part);
        });
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Part>getAllParts() {
        databaseExecutor.execute(()->{
            mAllParts = mPartDAO.getAllParts();
        });

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mAllParts;
    }

    public void updateProduct(Part part) {
        databaseExecutor.execute(() -> {
            mPartDAO.update(part);
        });

        try{
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(Part part) {
        databaseExecutor.execute(() -> {
            mPartDAO.delete(part);
        });

        try{
            Thread.sleep(1000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

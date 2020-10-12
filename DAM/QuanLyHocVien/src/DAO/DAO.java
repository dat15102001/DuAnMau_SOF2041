/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author nguyenvandat
 */
public abstract class DAO<E, K> {

    abstract public void Insert(E model);

    abstract public void Update(E model);

    abstract public void Delete(K key);

    abstract public void SelectAll();

    abstract public void SelectByID(K key);

    abstract protected void selectBySQL(String sql, Object... args);
}

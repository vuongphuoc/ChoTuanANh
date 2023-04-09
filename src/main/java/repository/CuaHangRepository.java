package repository;

import domainModel.CuaHang;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class CuaHangRepository {

    private Session hSession;
    public CuaHangRepository() {
        hSession = HibernateUtil.getFACTORY().openSession();
    }

    public List<CuaHang> findAll(){
        String hql = "Select obj from CuaHang obj";
        TypedQuery<CuaHang> query = hSession.createQuery(hql,CuaHang.class);
        return query.getResultList();
    }
    public void insert(CuaHang ch){
        Transaction transaction = hSession.getTransaction();
        try {
            transaction.begin();
            hSession.persist(ch);
            transaction.commit();
        }catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(CuaHang ch){
        Transaction transaction  = hSession.getTransaction();
        try {
            transaction.begin();
            hSession.merge(ch);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void delete(CuaHang ch){
        Transaction transaction  = hSession.getTransaction();
        try {
            transaction.begin();
            hSession.delete(ch);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public CuaHang findByMa(String ma){
        String hql = "select obj from CuaHang obj where obj.ma = ?1";
        TypedQuery<CuaHang> query =hSession.createQuery(hql,CuaHang.class);
        query.setParameter(1,ma);
        return query.getSingleResult();
    }




}

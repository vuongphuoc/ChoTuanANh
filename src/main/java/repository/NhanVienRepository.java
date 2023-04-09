package repository;

import domainModel.NhanVien;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class NhanVienRepository {
    Session hSession;
    public NhanVienRepository(){
        hSession = HibernateUtil.getFACTORY().openSession();
    }

    public List<NhanVien>findAll() {
        String hql = "select obj from NhanVien obj";
        TypedQuery<NhanVien> query = hSession.createQuery(hql, NhanVien.class);
        return query.getResultList();
    }

    public void insert(NhanVien nv){
        Transaction transaction = hSession.getTransaction();
        try {
            transaction.begin();
            hSession.persist(nv);
            transaction.commit();
        }catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void update(NhanVien nv){
        Transaction transaction = hSession.getTransaction();
        try {
            transaction.begin();
            hSession.merge(nv);
            transaction.commit();
        }catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void delete(NhanVien nv){
        Transaction transaction = hSession.getTransaction();
        try {
            transaction.begin();
            hSession.delete(nv);
            transaction.commit();
        }catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public NhanVien findByMa(String ma){
        String hql = "select obj from NhanVien obj where obj.Ma =?1";
        TypedQuery<NhanVien> query = hSession.createQuery(hql,NhanVien.class);
        query.setParameter(1,ma);
        return query.getSingleResult();

    }

}

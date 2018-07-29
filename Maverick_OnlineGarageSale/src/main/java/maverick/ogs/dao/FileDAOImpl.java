package maverick.ogs.dao;

import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import maverick.ogs.beans.File;
import maverick.ogs.util.HibernateUtil;

public class FileDAOImpl implements FileDAO {

	@Override
	public String insertFile(File file) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		String id = null;
		
		try {
			transaction = session.beginTransaction();
			id = (String)session.save(file);
			transaction.commit();
		}
		catch(HibernateException e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
		finally {
			session.close();
		}
		return id;
	}

	@Override
	public File getFileById(String Id) {
		File file = null;
		Session session = HibernateUtil.getSession();
		
		try {
			file = (File)session.get(File.class, Id);
		}
		catch(HibernateException e) {
			e.printStackTrace();
		}
		return file;
	}

	@Override
	public Boolean updateFileById(String fileId, File newFile) {
		File fileToUpdate = null;
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		Boolean result = false;
		
		try {
			transaction = session.beginTransaction();
			fileToUpdate = (File)session.get(File.class, fileId);
			if(fileToUpdate != null) {
				fileToUpdate.setFile(newFile.getFile());
			}
			session.save(fileToUpdate);
			transaction.commit();
			result = true;
		}
		catch(HibernateException e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
		finally {
			session.close();
		}
		
		return result;
	}

	@Override
	public Boolean deleteFileById(String fileId) {
		File file = null;
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		Boolean result = false;
		
		try {
			transaction = session.beginTransaction();
			file = (File)session.get(File.class, fileId);
			if(file != null) {
				session.delete(file);
				transaction.commit();
				result = true;
			}			
		}catch(HibernateException e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
		finally {
			session.close();
		}
		return result;
	}

}

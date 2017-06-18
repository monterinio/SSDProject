package pl.pwr.miki.DAO;

import java.io.IOException;
import java.nio.file.Paths;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import pl.pwr.miki.model.ReportDetailModel;
import pl.pwr.miki.model.ReportModel;

public class ReportDetailDAO {

	public boolean addReportToDB(HttpServletRequest request, long checksum) throws IOException, ServletException {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDB");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		ReportDetailModel reportDetailModel = entityManager.find(ReportDetailModel.class, checksum);
		entityManager.getTransaction().commit();
		if (reportDetailModel != null) {
			return false;
		}

		reportDetailModel = new ReportDetailModel();
		ReportModel reportModel = new ReportModel();
		
		extractDataFromRequest(request, reportModel, reportDetailModel);
		reportDetailModel.setHashValue(checksum);

		entityManager.getTransaction().begin();
		entityManager.persist(reportModel);
		entityManager.persist(reportDetailModel);
		entityManager.getTransaction().commit();
		
		entityManager.close();
        entityManagerFactory.close();

		return true;
	}

	private void extractDataFromRequest(HttpServletRequest request, ReportModel reportModel,
			ReportDetailModel reportDetailModel) throws IOException, ServletException {
		reportDetailModel.setFileName(Paths.get(request.getPart("report").getSubmittedFileName()).getFileName().toString());
		reportModel.setFileName(Paths.get(request.getPart("report").getSubmittedFileName()).getFileName().toString());
		reportModel.setFirstName(request.getParameter("firstName"));
		reportModel.setLastName(request.getParameter("lastName"));
		reportModel.setSubject(request.getParameter("subject"));
		reportModel.setTopic(request.getParameter("topic"));
	}
}
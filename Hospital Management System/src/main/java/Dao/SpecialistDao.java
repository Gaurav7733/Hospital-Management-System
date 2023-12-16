package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Entity.Specalist;

public class SpecialistDao {

	private Connection connection;

	public SpecialistDao(Connection connection) {
		super();
		this.connection = connection;
	}

	public boolean addSpecialist(String spec) {
		boolean f = false;
		try {
			String sql = "insert into specialist(name) values(?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, spec);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<Specalist> getAllSpecialist() {
		List<Specalist> list = new ArrayList<Specalist>();
		Specalist s = null;

		try {
			String sql = "select * from specialist";
			PreparedStatement ps = connection.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				s = new Specalist();
				s.setId(rs.getInt(1));
				s.setSpecialistName(rs.getString(2));
				list.add(s);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
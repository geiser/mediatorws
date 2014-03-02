package br.usp.ime.lapessc.mediator.dao.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import br.usp.ime.lapessc.mediator.dao.IQueryDao;
import br.usp.ime.lapessc.mediator.model.Metadata;
import br.usp.ime.lapessc.mediator.model.Property;
import br.usp.ime.lapessc.mediator.model.Relation;
import br.usp.ime.lapessc.mediator.model.Repository;

public class JDBCQueryDao implements IQueryDao {

	private final Connection con;

	public JDBCQueryDao(Connection con) {
		this.con = con;
	}

	public Metadata find(String id, Repository rep) {


		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> searchById(Metadata metadata, Repository rep) {
		String sql = rep.getMapGetElement();

		//-- change {type} for implode(metadata.type, ',')
		String singleType = ""; 
		for (String type : metadata.getTypes()) {
			singleType += "," + type;
		}
		singleType = singleType.substring(1);
		sql = sql.replaceAll("\\{type\\}", singleType);

		//-- change [{type  AND type='{value}' type}]
		String pluralType = "";
		String regexpType = sql.replaceAll("\\[\\{type\\s(.+)\\stype\\}\\]", "$1");
		for (String type : metadata.getTypes()) {
			pluralType += regexpType.replaceAll("\\{value\\}", type);
		}
		sql = sql.replaceAll("\\[\\{type\\s(.+)\\stype\\}\\]", pluralType);

		//-- change [{property  AND name='{name}' AND value='{value}' property}]
		String pluralProperty = "";
		String regexpProperty = sql.replaceAll("\\[\\{property\\s(.+)\\sproperty\\}\\]", "$1");
		for (Set<Property> propertySet : metadata.getProperties().values()) {
			for (Property property : propertySet) {
				String tmpPluralProperty = "";
				tmpPluralProperty = regexpProperty.replaceAll("\\{name\\}", property.getName());
				tmpPluralProperty = tmpPluralProperty.replaceAll("\\{value\\}", property.getValue());
				pluralProperty += tmpPluralProperty;
			}
		}
		sql = sql.replaceAll("\\[\\{property\\s(.+)\\sproperty\\}\\]", pluralProperty);

		//-- change [{relation  AND name='{name}' AND value='{value}' relation}]
		String pluralRelation = "";
		String regexpRelation = sql.replaceAll("\\[\\{relation\\s(.+)\\srelation\\}\\]", "$1");
		for (Set<Relation> relationSet : metadata.getRelations().values()) {
			for (Relation relation : relationSet) {
				String tmpPluralRelation = "";
				tmpPluralRelation = regexpRelation.replaceAll("\\{name\\}", relation.getName());
				tmpPluralRelation = tmpPluralRelation.replaceAll("\\{value\\}", relation.getValue());
				pluralRelation += tmpPluralRelation;
			}
		}
		sql = sql.replaceAll("\\[\\{relation\\s(.+)\\srelation\\}\\]", pluralRelation);

		//-- execute sql
		Set<String> result = new HashSet<String>();
		Statement stmt = null;
		try {
			stmt = this.con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				result.add(rs.getString(0));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Set<String> searchTypes(String id, Repository rep) {
		String sql = rep.getMapGetType().replaceAll("\\{id\\}", id);

		//-- execute sql
		Set<String> result = new HashSet<String>();
		Statement stmt = null;
		try {
			stmt = this.con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				result.add(rs.getString(0));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Set<String> searchPropertyValues(String id, String name, Repository rep) {
		String sql = rep.getMapGetPropertyValue().replaceAll("\\{id\\}", id);
		sql = sql.replaceAll("\\{name\\}", name);
		
		//-- execute sql
		Set<String> result = new HashSet<String>();
		Statement stmt = null;
		try {
			stmt = this.con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				result.add(rs.getString(0));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Set<String> searchRelated(String id, String name, Repository rep) {
		String sql = rep.getMapGetRelated().replaceAll("\\{id\\}", id);
		sql = sql.replaceAll("\\{name\\}", name);
		
		//-- execute sql
		Set<String> result = new HashSet<String>();
		Statement stmt = null;
		try {
			stmt = this.con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				result.add(rs.getString(0));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean buildElement(Metadata metadata, Repository rep) {		
		String sql = rep.getMapGetRelated().replaceAll("\\{id\\}", metadata.getId());
		
		//-- change {type} for implode(metadata.type, ',')
		String singleType = ""; 
		for (String type : metadata.getTypes()) {
			singleType += "," + type;
		}
		singleType = singleType.substring(1);
		sql = sql.replaceAll("\\{type\\}", singleType);

		//-- change [{type  AND type='{value}' type}]
		String pluralType = "";
		String regexpType = sql.replaceAll("\\[\\{type\\s(.+)\\stype\\}\\]", "$1");
		for (String type : metadata.getTypes()) {
			pluralType += regexpType.replaceAll("\\{value\\}", type);
		}
		sql = sql.replaceAll("\\[\\{type\\s(.+)\\stype\\}\\]", pluralType);

		//-- change [{property  AND name='{name}' AND value='{value}' property}]
		String pluralProperty = "";
		String regexpProperty = sql.replaceAll("\\[\\{property\\s(.+)\\sproperty\\}\\]", "$1");
		for (Set<Property> propertySet : metadata.getProperties().values()) {
			for (Property property : propertySet) {
				String tmpPluralProperty = "";
				tmpPluralProperty = regexpProperty.replaceAll("\\{name\\}", property.getName());
				tmpPluralProperty = tmpPluralProperty.replaceAll("\\{value\\}", property.getValue());
				pluralProperty += tmpPluralProperty;
			}
		}
		sql = sql.replaceAll("\\[\\{property\\s(.+)\\sproperty\\}\\]", pluralProperty);

		//-- change [{relation  AND name='{name}' AND value='{value}' relation}]
		String pluralRelation = "";
		String regexpRelation = sql.replaceAll("\\[\\{relation\\s(.+)\\srelation\\}\\]", "$1");
		for (Set<Relation> relationSet : metadata.getRelations().values()) {
			for (Relation relation : relationSet) {
				String tmpPluralRelation = "";
				tmpPluralRelation = regexpRelation.replaceAll("\\{name\\}", relation.getName());
				tmpPluralRelation = tmpPluralRelation.replaceAll("\\{value\\}", relation.getValue());
				pluralRelation += tmpPluralRelation;
			}
		}
		sql = sql.replaceAll("\\[\\{relation\\s(.+)\\srelation\\}\\]", pluralRelation);		
		
		//-- execute sql
		Statement stmt = null;
		try {
			stmt = this.con.createStatement();
			return stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}

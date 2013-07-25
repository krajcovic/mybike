package cz.krajcovic.mybike.client.table;

import java.util.List;

import com.google.gwt.user.client.ui.FlexTable;

import cz.krajcovic.mybike.client.model.Bike;

public class FormatedTable extends FlexTable {

	private DataSource data;

	public FormatedTable(DataSource data) {
		super();
		this.setCellPadding(1);
		this.setCellSpacing(0);
		this.setWidth("100%");
		this.setData(data);

	}

	public DataSource getData() {
		return data;
	}

	public void setData(DataSource data) {

		this.removeAllRows();

		if (data == null) {
			return;
		}

		int row = 0;
		List<String> headers = data.getTableHeader();
		if (headers != null) {
			int i = 0;
			for (String item : headers) {
				this.setText(row, i++, item);
			}
			row++;
		}

		// Make the table header look nicer
		this.getRowFormatter().addStyleName(0, "tableHeader");

		int i = 1;
		for (Bike bike : data.getBikes()) {
			this.setText(i, 0, bike.getId().toString());
			this.setText(i, 1, bike.getNickname());
			this.setText(i, 2, bike.getStatus().toString());
			i++;
		}

		this.data = data;
	}

}

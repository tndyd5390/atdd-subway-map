package nextstep.subway.applicaion.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import nextstep.subway.domain.Line;

public class LineResponse {
	private Long id;
	private String name;
	private String color;
	private List<StationResponse> stations = new ArrayList<>();

	public LineResponse() {
	}

	public LineResponse(Long id, String name, String color, List<StationResponse> stations) {
		this.id = id;
		this.name = name;
		this.color = color;
		this.stations = stations;
	}

	public static LineResponse from(Line line) {
		return new LineResponse(line.getId(), line.getName(), line.getColor(), StationResponse.fromList(List.of(line.getUpStation(),
			line.getDownStation())));
	}

	public static List<LineResponse> fromList(List<Line> lineList) {
		return lineList.stream().map(LineResponse::from).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}

	public List<StationResponse> getStations() {
		return stations;
	}
}

package challenge;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.opencsv.bean.CsvToBeanBuilder;

public class Main {

	private List<Jogador> jogadores = new ArrayList<>();

	public Main() {
		try {
			carregarDados();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void carregarDados() throws FileNotFoundException {

		FileReader leitor = abrirArquivo();

		jogadores = new CsvToBeanBuilder(leitor).withType(Jogador.class).build().parse();
	}

	private FileReader abrirArquivo() throws FileNotFoundException {

		URL url = getClass().getClassLoader().getResource("data.csv");

		if (url == null)
			return null;

		return new FileReader(url.getFile());
	}

	// Quantas nacionalidades (coluna `nationality`) diferentes existem no arquivo?
	public int q1() {
		return (int) jogadores.stream().map(Jogador::getNationality).distinct().count();
	}

	// Quantos clubes (coluna `club`) diferentes existem no arquivo?
	// Obs: Existem jogadores sem clube.
	public int q2() {
		return (int) jogadores.stream().filter(j -> !(j.getClub().isEmpty())).map(Jogador::getClub).distinct().count();
	}

	// Liste o nome completo (coluna `full_name`) dos 20 primeiros jogadores.
	public List<String> q3() {
		return jogadores.stream().limit(20).map(Jogador::getFullName).collect(Collectors.toList());
	}

	// Quem são os top 10 jogadores que possuem as maiores cláusulas de rescisão?
	// (utilize as colunas `full_name` e `eur_release_clause`)
	public List<String> q4() {
		return jogadores.stream().filter(j -> j.getEurReleaseClause() != null)
				.sorted(Comparator.comparingDouble(Jogador::getEurReleaseClause).reversed()).limit(10)
				.map(Jogador::getFullName).collect(Collectors.toList());
	}

	// Quem são os 10 jogadores mais velhos (use como critério de desempate o
	// campo `eur_wage`)?
	// (utilize as colunas `full_name` e `birth_date`)
	public List<String> q5() {
		/// Comparator<Jogador> comparator = Comparator.comparing(Jogador::getBirthDate)
		// .thenComparing(Jogador::getEurWage);

		// return
		// jogadores.stream().sorted(comparator).limit(10).map(Jogador::getFullName).collect(Collectors.toList());
		return jogadores.stream()
				.sorted(Comparator.comparing(Jogador::getBirthDate)
						.thenComparing(Comparator.comparing(Jogador::getEurWage)))
				.limit(10).map(Jogador::getFullName).collect(Collectors.toList());
	}

	// Conte quantos jogadores existem por idade. Para isso, construa um mapa onde
	// as chaves são as idades e os valores a contagem.
	// (utilize a coluna `age`)
	public Map<Integer, Integer> q6() {
		Collector<Object, ?, Integer> contador = Collectors.reducing(0, e -> 1, Integer::sum);

		return jogadores.stream().sorted(Comparator.comparingInt(Jogador::getAge))
				.collect(Collectors.groupingBy(Jogador::getAge, contador));
	}

}

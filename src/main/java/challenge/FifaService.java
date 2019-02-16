package challenge;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

public class FifaService {
	private List<Jogador> jogadores = new ArrayList<>();

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
}

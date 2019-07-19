package teste.supero.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

public class Livro
{

   private Long id;
   private String titulo;
   private Long isbn;
   private String autor;
   private String editora;
   private Long ano;
   private String idioma;
   private Long peso;
   private Long comprimento;
   private Long largura;
   private Long altura;

   /**
    * @deprecated frameworks only
    */
   public Livro()
   {
   }

   public Livro(String titulo)
   {
      this.titulo = titulo;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getTitulo() {
      return titulo;
   }

   public void setTitulo(String titulo) {
      this.titulo = titulo;
   }

   public Long getIsbn() {
      return isbn;
   }

   public void setIsbn(Long isbn) {
      this.isbn = isbn;
   }

   public String getAutor() {
      return autor;
   }

   public void setAutor(String autor) {
      this.autor = autor;
   }

   public String getEditora() {
      return editora;
   }

   public void setEditora(String editora) {
      this.editora = editora;
   }

   public Long getAno() {
      return ano;
   }

   public void setAno(Long ano) {
      this.ano = ano;
   }

   public String getIdioma() {
      return idioma;
   }

   public void setIdioma(String idioma) {
      this.idioma = idioma;
   }

   public Long getPeso() {
      return peso;
   }

   public void setPeso(Long peso) {
      this.peso = peso;
   }

   public Long getComprimento() {
      return comprimento;
   }

   public void setComprimento(Long comprimento) {
      this.comprimento = comprimento;
   }

   public Long getLargura() {
      return largura;
   }

   public void setLargura(Long largura) {
      this.largura = largura;
   }

   public Long getAltura() {
      return altura;
   }

   public void setAltura(Long altura) {
      this.altura = altura;
   }

   @Override
   public String toString()
   {
      return "Livro [" + titulo + "]";
   }

}

package beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import sistema.System;
import sistema.Text;
import exception.ThereAreNoMoreLinesException;
import exception.InvalidRecombinatorException;

@SessionScoped
@ManagedBean(name = "Recombinator")
public class RecombinationBean {
	private System system;
	private String currentText;
	private List<Text> texts;
	private List<String> recombinators;
	private String currentRecombinator;

	@PostConstruct
	public void init(){
		setRecombinators(system.getRecombiners());
		setText(system.getTexts());
		setCurrentRecombinator(recombinators.get(0));
	}
	
	
	public RecombinationBean() {
		system = new System();
	}
	
	
	public String getCurrentText() {
		return currentText;
	}

	public void setCurrentText(String currentText) {
		this.currentText = currentText;
	}

	public List<Text> getTexts() {
		return system.getTexts();
	}

	public void setText(List<Text> texts) {
		this.texts = texts;
	}

	public String getCurrentRecombinator() {
		return currentRecombinator;
	}

	public void setCurrentRecombinator(String currentRecombinator) {
		this.currentRecombinator = currentRecombinator;
	}

	public List<String> getRecombinators() {
		return recombinators;
	}

	public void setRecombinators(List<String> recombinators) {
		this.recombinators = recombinators;
	}
	
	public String addLine(){

		try {
			currentText = currentText + system.getNewLine();
		} catch (ThereAreNoMoreLinesException e) {
			FacesContext context = FacesContext.getCurrentInstance();  
			context.addMessage(null, new FacesMessage(e.getMessage()));   
	        return "";
		}
		return "";
	}
	
	public String checkTexts(){
		FacesContext context = FacesContext.getCurrentInstance();  
        if(texts.isEmpty())   {
        	context.addMessage(null, new FacesMessage("Add a text first"));   
        return "";
        }
        currentText = texts.get(0).getTextIntro();
		return "recombinationTextList.xhtml";		
	}
	
	public String addText(){
		system.newTexto(currentText);
		currentText = "";
		FacesContext context = FacesContext.getCurrentInstance();  
		context.addMessage(null, new FacesMessage("Text Successfully Saved!"));   
		return "index.xhtml";
	}
	
	public String cancel(){
		currentText = "";
		return "index.xhtml";
	}
	
	public String recombine(){	
		try {
			system.setUpRecombiner(currentRecombinator, currentText);
		} catch (InvalidRecombinatorException e) {
			FacesContext context = FacesContext.getCurrentInstance(); 
			context.addMessage(null, new FacesMessage(e.getMessage()));   
		}
		currentText = "";
		return "textRecombination.xhtml";
	}
}

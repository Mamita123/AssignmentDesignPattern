import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history; // Memento history

    private List<IMemento> undoList; // Undo list
    private List<IMemento> redoList; // Redo list

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.undoList = new ArrayList<>();
        this.redoList = new ArrayList<>();
    }

    public void setOption(int optionNumber, int choice) {
        saveToHistory();
        model.setOption(optionNumber, choice);
    }

    public List<IMemento> getHistoryList(){
        return history;
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToHistory();
        model.setIsSelected(isSelected);
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public List<IMemento> getUndoList() {
        return undoList;
    }

    public List<IMemento> getRedoList() {
        return redoList;
    }


    public void restoreState(int index) {
        if (index >= 0 && index < undoList.size()) {
            IMemento memento = undoList.get(index);
            model.restoreState(memento);
            undoList.subList(index + 1, undoList.size()).clear();
            redoList.clear(); // Clear redo list when a state is restored from history
            gui.updateGui();
        }
    }


    public void undo() {
        if (!undoList.isEmpty()) {
            IMemento previousState = undoList.remove(undoList.size() - 1);
            redoList.add(model.createMemento()); // Add current state to redo list
            model.restoreState(previousState);
            gui.updateGui();

        /*if (!history.isEmpty()) {
            System.out.println("Memento found in history");
            IMemento previousState = history.remove(history.size() - 1);
            model.restoreState(previousState);
            gui.updateGui();*/
        }
    }
    public void redo() {
        if (!redoList.isEmpty()) {
            IMemento nextState = redoList.remove(redoList.size() - 1);
            undoList.add(model.createMemento()); // Add current state to undo list
            model.restoreState(nextState);
            gui.updateGui();
        }
    }



    private void saveToHistory() {

        IMemento currentState = model.createMemento();
        history.add(currentState);
    }
}


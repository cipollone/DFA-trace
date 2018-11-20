/* Clause class */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Clause {
	
	private int index;

	private List<Variable> positiveVariables = new ArrayList<>();

	private List<Variable> negatedVariables = new ArrayList<>();

	public void addPositiveVariable(Variable variable) {
		positiveVariables.add(variable);
	}

	public void addNegatedVariable(Variable variable) {
		negatedVariables.add(variable);
	}

	public Clause(int i) {
		this.index = i;
	}

	public boolean isSatisfied() {
		for (Variable variable : positiveVariables) {
			if (variable.isTrue()) {
				return true;
			}
		}
		for (Variable variable : negatedVariables) {
			if (variable.isFalse()) {
				return true;
			}
		}
		return false;
	}

	public Set<Variable> getAllVariables() {
		Set<Variable> variables = new HashSet<>();
		variables.addAll(positiveVariables);
		variables.addAll(negatedVariables);
		return variables;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		String separator = "";
		for (Variable variable : positiveVariables) {
			sb.append(separator);
			separator = " V ";
			sb.append(variable.toString());
		}
		for (Variable variable : negatedVariables) {
			sb.append(separator);
			separator = " V ";
			sb.append("-" + variable.toString());
		}
		sb.append(")");
		return sb.toString();
	}

	// @Override
	// public equal(Object o) {
	// 		if (o == null) {
 //          return false;
 //      }

 //      if (o == this) {
 //          return true;
 //      }

 //      if (!getClass().equals(o.getClass())) {
 //          return false;
 //      }

 //      return index == ((BinaryVariable) o).index;
	// }	      
}
public enum AlgorithmStep {
    INSPECTING {
        public void execute(BruteForceAlgorithm algorithm) {
            algorithm.highlightInspectedCharacter(algorithm.getCurrentIndex());
            algorithm.getIndexField().setText(String.valueOf(algorithm.getCurrentIndex()));
        }
    },
    MATCHING {
        public void execute(BruteForceAlgorithm algorithm) {
            algorithm.incrementPatternMatchIndex();
            algorithm.highlightTextArea(
                    algorithm.getCurrentIndex() - algorithm.getPatternMatchIndex() + 1,
                    algorithm.getCurrentIndex() + 1
            );
            algorithm.highlightPatternField(algorithm.getPatternMatchIndex());
        }
    },
    COMPLETED {
        public void execute(BruteForceAlgorithm algorithm) {
            algorithm.showMessage("Pattern fully matched at index: " + (algorithm.getCurrentIndex() - algorithm.getPatternMatchIndex() + 1));
            algorithm.resetPatternMatchIndex();
        }
    },
    NOT_MATCHING {
        public void execute(BruteForceAlgorithm algorithm) {
            algorithm.resetPatternMatchIndex();
            algorithm.clearPatternHighlight();
        }
    };

    public abstract void execute(BruteForceAlgorithm algorithm);
}

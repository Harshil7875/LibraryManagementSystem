# LibraryManagementSystem/compile_and_run.sh

# Define paths
SRC_DIR="src"
BIN_DIR="bin"
DATA_DIR="data"
MAIN_CLASS="Main"
DATA_FILE="$DATA_DIR/Library_data.txt"

# Create necessary directories if they don't exist
echo "Setting up the project..."
mkdir -p "$BIN_DIR" "$DATA_DIR"

# Check if the src directory exists
if [ ! -d "$SRC_DIR" ]; then
  echo "Error: Source directory '$SRC_DIR' not found."
  exit 1
fi

# Compile the Java files
echo "Compiling the source files..."
javac -d "$BIN_DIR" "$SRC_DIR"/*.java
if [ $? -ne 0 ]; then
  echo "Compilation failed. Please check your code for errors."
  exit 1
fi
echo "Compilation successful."

# Check if the data file exists, if not, initialize it
if [ ! -f "$DATA_FILE" ]; then
  echo "Initializing data file at '$DATA_FILE'..."
  touch "$DATA_FILE"
fi

# Run the program
echo "Running the program..."
java -cp "$BIN_DIR" "$MAIN_CLASS"
if [ $? -ne 0 ]; then
  echo "Error: Program execution failed."
  exit 1
fi

# Finish
echo "Program execution completed."



# Auth API Stop Script
echo "🛑 Stopping Auth API..."

# Find and kill the Spring Boot application process
PID=$(pgrep -f "spring-boot:run")

if [ -z "$PID" ]; then
    echo "❌ No running Auth API process found"
    exit 1
fi

# Kill the process gracefully
echo "🔍 Found process ID: $PID"
kill $PID

# Wait for process to stop
sleep 5

# Check if process is still running
if pgrep -f "spring-boot:run" > /dev/null; then
    echo "⚠️  Process still running, force killing..."
    kill -9 $PID
    sleep 2
fi

# Verify process is stopped
if pgrep -f "spring-boot:run" > /dev/null; then
    echo "❌ Failed to stop Auth API"
    exit 1
else
    echo "✅ Auth API stopped successfully"
fi


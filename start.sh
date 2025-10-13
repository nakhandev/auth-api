

# Auth API Start Script
echo "🚀 Starting Auth API..."

# Check if application is already running
if pgrep -f "spring-boot:run" > /dev/null; then
    echo "❌ Application is already running"
    exit 1
fi

# Navigate to project directory
cd .

# Start the Spring Boot application
echo "📦 Starting Spring Boot application..."
mvn spring-boot:run > auth-api.log 2>&1 &

# Wait a moment then check if it's running
sleep 10

if pgrep -f "spring-boot:run" > /dev/null; then
    echo "📍 Application URL: http://localhost:8080"
    echo "📝 Logs available at: auth-api.log"
else
    echo "❌ Failed to start Auth API. Check auth-api.log for details."
    exit 1
fi


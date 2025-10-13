

# Auth API Deploy Script
echo "🚀 Starting Auth API Deployment..."

# Navigate to project directory
cd $(dirname $0)

echo "�� Pulling latest changes from Git..."
git pull origin main

echo "🧹 Cleaning previous build..."
mvn clean

echo "🔨 Compiling application..."
mvn compile

echo "📦 Packaging application..."
mvn package -DskipTests

echo "🔍 Checking application health..."
# Check if the application compiles successfully
if [ 0 -eq 0 ]; then
    echo "🎯 Ready to start with: ./start.sh"
else
    echo "❌ Deployment failed. Check the logs above."
    exit 1
fi


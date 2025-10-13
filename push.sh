

# Auth API Push to GitHub Script
echo "🚀 Pushing Auth API to GitHub..."

# Check if we're in a git repository
if ! git rev-parse --git-dir > /dev/null 2>&1; then
    echo "❌ Not in a git repository"
    exit 1
fi

# Check if remote origin exists
if ! git remote get-url origin > /dev/null 2>&1; then
    echo "📡 Setting up GitHub remote for user: nakhandev"
    git remote add origin https://github.com/nakhandev/auth-api.git
fi

# Add all changes
echo "📦 Adding all changes..."
git add .

# Check if there are changes to commit
if git diff --cached --quiet; then
    echo "✅ No changes to commit"
    echo "🔄 Pulling latest changes from GitHub..."
    git pull origin main || git pull origin master
    exit 0
fi

# Get commit message
if [ -z "$1" ]; then
    echo "📝 Enter commit message:"
    read commit_message
    if [ -z "$commit_message" ]; then
        commit_message="Update: $(date +'%Y-%m-%d %H:%M:%S')"
    fi
else
    commit_message="$1"
fi

# Commit changes
echo "💾 Committing changes: $commit_message"
git commit -m "$commit_message"

# Push to GitHub
echo "⬆️  Pushing to GitHub..."
if git push -u origin main 2>/dev/null; then
    echo "🌐 Repository: https://github.com/nakhandev/auth-api"
elif git push -u origin master 2>/dev/null; then
    echo "🌐 Repository: https://github.com/nakhandev/auth-api"
else
    echo "❌ Failed to push to GitHub. Check your credentials and network connection."
    exit 1
fi

